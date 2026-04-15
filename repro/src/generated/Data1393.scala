package generated

final case class Data1393(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1393 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1393 = copy(value = value * k)
  def addTag(t: String): Data1393 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1393 = copy(meta = meta.updated(k, v))
  def merge(other: Data1393): Data1393 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1393 {
  given Ordering[Data1393] = Ordering.by(_.id)
  def empty: Data1393 = Data1393(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1393 =
    Data1393(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1393] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
