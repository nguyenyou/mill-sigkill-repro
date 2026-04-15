package generated

final case class Data1421(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1421 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1421 = copy(value = value * k)
  def addTag(t: String): Data1421 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1421 = copy(meta = meta.updated(k, v))
  def merge(other: Data1421): Data1421 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1421 {
  given Ordering[Data1421] = Ordering.by(_.id)
  def empty: Data1421 = Data1421(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1421 =
    Data1421(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1421] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
