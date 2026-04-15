package generated

final case class Data1043(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1043 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1043 = copy(value = value * k)
  def addTag(t: String): Data1043 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1043 = copy(meta = meta.updated(k, v))
  def merge(other: Data1043): Data1043 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1043 {
  given Ordering[Data1043] = Ordering.by(_.id)
  def empty: Data1043 = Data1043(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1043 =
    Data1043(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1043] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
