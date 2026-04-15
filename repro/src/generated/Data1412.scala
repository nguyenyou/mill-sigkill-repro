package generated

final case class Data1412(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1412 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1412 = copy(value = value * k)
  def addTag(t: String): Data1412 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1412 = copy(meta = meta.updated(k, v))
  def merge(other: Data1412): Data1412 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1412 {
  given Ordering[Data1412] = Ordering.by(_.id)
  def empty: Data1412 = Data1412(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1412 =
    Data1412(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1412] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
