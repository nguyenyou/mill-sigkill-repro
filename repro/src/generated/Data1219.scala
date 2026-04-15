package generated

final case class Data1219(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1219 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1219 = copy(value = value * k)
  def addTag(t: String): Data1219 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1219 = copy(meta = meta.updated(k, v))
  def merge(other: Data1219): Data1219 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1219 {
  given Ordering[Data1219] = Ordering.by(_.id)
  def empty: Data1219 = Data1219(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1219 =
    Data1219(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1219] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
