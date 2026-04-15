package generated

final case class Data1102(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1102 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1102 = copy(value = value * k)
  def addTag(t: String): Data1102 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1102 = copy(meta = meta.updated(k, v))
  def merge(other: Data1102): Data1102 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1102 {
  given Ordering[Data1102] = Ordering.by(_.id)
  def empty: Data1102 = Data1102(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1102 =
    Data1102(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1102] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
