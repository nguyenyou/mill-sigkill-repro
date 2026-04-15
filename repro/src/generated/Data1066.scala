package generated

final case class Data1066(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1066 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1066 = copy(value = value * k)
  def addTag(t: String): Data1066 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1066 = copy(meta = meta.updated(k, v))
  def merge(other: Data1066): Data1066 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1066 {
  given Ordering[Data1066] = Ordering.by(_.id)
  def empty: Data1066 = Data1066(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1066 =
    Data1066(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1066] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
