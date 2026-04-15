package generated

final case class Data1070(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1070 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1070 = copy(value = value * k)
  def addTag(t: String): Data1070 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1070 = copy(meta = meta.updated(k, v))
  def merge(other: Data1070): Data1070 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1070 {
  given Ordering[Data1070] = Ordering.by(_.id)
  def empty: Data1070 = Data1070(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1070 =
    Data1070(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1070] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
