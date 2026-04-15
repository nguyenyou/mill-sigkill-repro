package generated

final case class Data1008(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1008 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1008 = copy(value = value * k)
  def addTag(t: String): Data1008 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1008 = copy(meta = meta.updated(k, v))
  def merge(other: Data1008): Data1008 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1008 {
  given Ordering[Data1008] = Ordering.by(_.id)
  def empty: Data1008 = Data1008(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1008 =
    Data1008(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1008] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
