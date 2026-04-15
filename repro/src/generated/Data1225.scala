package generated

final case class Data1225(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1225 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1225 = copy(value = value * k)
  def addTag(t: String): Data1225 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1225 = copy(meta = meta.updated(k, v))
  def merge(other: Data1225): Data1225 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1225 {
  given Ordering[Data1225] = Ordering.by(_.id)
  def empty: Data1225 = Data1225(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1225 =
    Data1225(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1225] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
