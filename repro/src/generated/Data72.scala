package generated

final case class Data72(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data72 = copy(name = name.toUpperCase)
  def scale(k: Double): Data72 = copy(value = value * k)
  def addTag(t: String): Data72 = copy(tags = t :: tags)
  def put(k: String, v: String): Data72 = copy(meta = meta.updated(k, v))
  def merge(other: Data72): Data72 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data72 {
  given Ordering[Data72] = Ordering.by(_.id)
  def empty: Data72 = Data72(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data72 =
    Data72(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data72] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
