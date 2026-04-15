package generated

final case class Data1040(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1040 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1040 = copy(value = value * k)
  def addTag(t: String): Data1040 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1040 = copy(meta = meta.updated(k, v))
  def merge(other: Data1040): Data1040 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1040 {
  given Ordering[Data1040] = Ordering.by(_.id)
  def empty: Data1040 = Data1040(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1040 =
    Data1040(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1040] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
