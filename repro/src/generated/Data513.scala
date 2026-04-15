package generated

final case class Data513(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data513 = copy(name = name.toUpperCase)
  def scale(k: Double): Data513 = copy(value = value * k)
  def addTag(t: String): Data513 = copy(tags = t :: tags)
  def put(k: String, v: String): Data513 = copy(meta = meta.updated(k, v))
  def merge(other: Data513): Data513 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data513 {
  given Ordering[Data513] = Ordering.by(_.id)
  def empty: Data513 = Data513(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data513 =
    Data513(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data513] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
