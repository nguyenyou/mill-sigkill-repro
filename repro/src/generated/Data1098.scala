package generated

final case class Data1098(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1098 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1098 = copy(value = value * k)
  def addTag(t: String): Data1098 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1098 = copy(meta = meta.updated(k, v))
  def merge(other: Data1098): Data1098 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1098 {
  given Ordering[Data1098] = Ordering.by(_.id)
  def empty: Data1098 = Data1098(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1098 =
    Data1098(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1098] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
