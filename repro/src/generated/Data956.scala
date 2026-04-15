package generated

final case class Data956(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data956 = copy(name = name.toUpperCase)
  def scale(k: Double): Data956 = copy(value = value * k)
  def addTag(t: String): Data956 = copy(tags = t :: tags)
  def put(k: String, v: String): Data956 = copy(meta = meta.updated(k, v))
  def merge(other: Data956): Data956 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data956 {
  given Ordering[Data956] = Ordering.by(_.id)
  def empty: Data956 = Data956(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data956 =
    Data956(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data956] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
