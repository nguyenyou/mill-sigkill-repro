package generated

final case class Data1175(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1175 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1175 = copy(value = value * k)
  def addTag(t: String): Data1175 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1175 = copy(meta = meta.updated(k, v))
  def merge(other: Data1175): Data1175 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1175 {
  given Ordering[Data1175] = Ordering.by(_.id)
  def empty: Data1175 = Data1175(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1175 =
    Data1175(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1175] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
