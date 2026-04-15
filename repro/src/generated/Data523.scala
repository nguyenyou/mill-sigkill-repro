package generated

final case class Data523(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data523 = copy(name = name.toUpperCase)
  def scale(k: Double): Data523 = copy(value = value * k)
  def addTag(t: String): Data523 = copy(tags = t :: tags)
  def put(k: String, v: String): Data523 = copy(meta = meta.updated(k, v))
  def merge(other: Data523): Data523 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data523 {
  given Ordering[Data523] = Ordering.by(_.id)
  def empty: Data523 = Data523(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data523 =
    Data523(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data523] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
