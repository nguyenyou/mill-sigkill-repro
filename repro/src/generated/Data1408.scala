package generated

final case class Data1408(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1408 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1408 = copy(value = value * k)
  def addTag(t: String): Data1408 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1408 = copy(meta = meta.updated(k, v))
  def merge(other: Data1408): Data1408 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1408 {
  given Ordering[Data1408] = Ordering.by(_.id)
  def empty: Data1408 = Data1408(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1408 =
    Data1408(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1408] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
