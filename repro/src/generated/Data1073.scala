package generated

final case class Data1073(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1073 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1073 = copy(value = value * k)
  def addTag(t: String): Data1073 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1073 = copy(meta = meta.updated(k, v))
  def merge(other: Data1073): Data1073 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1073 {
  given Ordering[Data1073] = Ordering.by(_.id)
  def empty: Data1073 = Data1073(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1073 =
    Data1073(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1073] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
