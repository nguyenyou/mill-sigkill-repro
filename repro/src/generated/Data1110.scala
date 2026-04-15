package generated

final case class Data1110(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1110 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1110 = copy(value = value * k)
  def addTag(t: String): Data1110 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1110 = copy(meta = meta.updated(k, v))
  def merge(other: Data1110): Data1110 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1110 {
  given Ordering[Data1110] = Ordering.by(_.id)
  def empty: Data1110 = Data1110(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1110 =
    Data1110(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1110] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
