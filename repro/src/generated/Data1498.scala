package generated

final case class Data1498(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1498 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1498 = copy(value = value * k)
  def addTag(t: String): Data1498 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1498 = copy(meta = meta.updated(k, v))
  def merge(other: Data1498): Data1498 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1498 {
  given Ordering[Data1498] = Ordering.by(_.id)
  def empty: Data1498 = Data1498(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1498 =
    Data1498(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1498] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
